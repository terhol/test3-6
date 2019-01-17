package se.terhol.pisemka36;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tereza Holm
 */
public class CigaretteAutomat implements ICigaretteAutomat {
    private Map<CigaretteBrand, Integer> automat = new HashMap<>();

    public CigaretteAutomat(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        this.load(is);
    }

    @Override
    public void sell(CigaretteBrand cigarette, int numPacks) throws UnknownProductException, OutOfStockException {
        if (numPacks < 0) {
            throw new IllegalArgumentException();
        }
        if (!automat.containsKey(cigarette)) {
            throw new UnknownProductException();
        }
        if (automat.get(cigarette) < numPacks) {
            throw new OutOfStockException();
        }
        int newNumOfPacks = automat.get(cigarette) - numPacks;
        automat.put(cigarette, newNumOfPacks);
    }

    @Override
    public void restock(CigaretteBrand cigarette, int numPacks) {
        if (cigarette == null) {
            throw new NullPointerException();
        }
        if (numPacks < 0) {
            throw new IllegalArgumentException();
        }
        if (automat.containsKey(cigarette)) {
            int newNumOfPacks = automat.get(cigarette) + numPacks;
            automat.put(cigarette, newNumOfPacks);
        } else {
            automat.put(cigarette, numPacks);
        }
    }

    @Override
    public void save(OutputStream os) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os))) {
            for (CigaretteBrand cigarette : automat.keySet()) {
                writer.write(String.format("%d %d %s", automat.get(cigarette), cigarette.getPrice(), cigarette.getLabel()));
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            System.err.println("Could not save.");
        }
    }

    @Override
    public void load(InputStream is) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line = reader.readLine();
            while (line != null) {
                this.addCigarette(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Could not load file.");
        }
    }

    private void addCigarette(String line) {
        int firstSpace = line.indexOf(" ");
        int secondSpace = line.indexOf(" ", firstSpace + 1);
        int numOfPacks = Integer.parseInt(line.substring(0, firstSpace));
        int price = Integer.parseInt(line.substring(firstSpace + 1, secondSpace));
        String label = line.substring(secondSpace + 1);
        automat.put(new CigaretteBrand(label, price), numOfPacks);
    }
}
