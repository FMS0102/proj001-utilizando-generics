package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.entites.Product;
import model.services.CalculationService;

/**
 *
 * O programa deverá coletar o preço de vários produtos retirados de um arquivo
 * .csv Retornar o produto com o valor mais alto da listagem e a porcentagem
 * dele em relação ao total
 */
public class Program {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        List<Product> list = new ArrayList<>();
        
        String path = "docs/Products.csv";
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while(line != null){
                String[] split = line.split(",");
                list.add(new Product(split[0], Double.parseDouble(split[1])));
                line = br.readLine();
            }
            
            Product x = CalculationService.max(list);
            System.out.println("Produto com o valor mais alto: ");
            System.out.println(x);
            
            sc.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
