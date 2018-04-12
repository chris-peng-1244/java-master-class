package com.chrispeng.section15;

import java.io.FileWriter;
import java.io.IOException;

public class InputOutputMain {
	private static Locations locations = new Locations();

	public static void main(String[] args) {
		try(FileWriter locFile = new FileWriter("locations.txt");
		    FileWriter dirFile = new FileWriter("directions.txt")
		) {
			for (Location location: locations.values()) {
				locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
				for (String direction: location.getExits().keySet()) {
					dirFile.write(location.getLocationID() + "," + direction + ","+location.getExits().get(direction) + "\n");
				}
			}
		} catch (IOException e) {
			System.out.println("In catch block");
			e.printStackTrace();
		}
	}
}
