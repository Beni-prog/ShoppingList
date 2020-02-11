package Repository;

import Domain.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Repo {
    private String filename;
    private ArrayList<Product> products=new ArrayList<>();

    public Repo(String filename) {
        this.filename = filename;
        this.readProducts(filename);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void readProducts(String filename)
    {
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(filename));
            String line = null;
            while ((line = br.readLine()) != null)
            {
                String[] elems = line.split(",");
                if (elems.length < 5)
                    continue;
                Product b = new Product(Integer.parseInt(elems[0].strip()), elems[1].strip(),elems[2].strip(),Integer.parseInt(elems[3].strip()),Integer.parseInt(elems[4].strip()));
                this.products.add(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br != null)
                try {
                    br.close();
                }
                catch (IOException e)
                {
                    System.out.println("Error while closing the file " + e);
                }
        }


    }
}
