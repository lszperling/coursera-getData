package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import Test.IntegrationTest;


public class StatsDeTests {	


	public static void main(String[] args) {
		ParserGroups parser = new ParserGroups();
		String fileName = "C:/Users/Leonel/Desktop/list_of_names.txt";
		Collection<String> filenames = parser.parsear(fileName);
		int unitTestCount = 0;
		int integrationTestCount = 0;

		for (String filepath : filenames){
			try {
				File file = new File(filepath);
				Scanner scanner;

				scanner = new Scanner(file);

				boolean isTest = false;
				boolean isIntegrationTest = false;
				boolean isBlackbox = false;

				while (scanner.hasNextLine() && !isIntegrationTest){
					String line = scanner.nextLine();
					if (line.contains("org.junit.Test")){
						isTest = true;
					}
					if (line.contains("extends IntegrationTest")){
						isIntegrationTest = true;
					}
				}

				if(isIntegrationTest){
					integrationTestCount++;
				}

				if(!isIntegrationTest && isTest){
					unitTestCount++;
				}
				scanner.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		System.out.println("La cantida de test normales es: " + unitTestCount);
		System.out.println("La cantida de test de Integracion es: " + integrationTestCount);
	}


}
