package com.chrispeng.section15;

import java.io.*;

public class InputOutputMain {
	private static Locations locations = new Locations();

	public static void main(String[] args) throws IOException {
		try(DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
			for (Location location: locations.values()) {
				locFile.writeInt(location.getLocationID());
				locFile.writeUTF(location.getDescription());
				System.out.println("Writing location: " + location.getLocationID() + "," + location.getDescription());
				System.out.println("Writing " + (location.getExits().size() - 1) + " exits.");
				locFile.writeInt(location.getExits().size() - 1);
				for (String direction: location.getExits().keySet()) {
					if (!direction.equalsIgnoreCase("Q")) {
						System.out.println("\t\t" + direction + "," + location.getExits().get(direction));
						locFile.writeUTF(direction);
						locFile.writeInt(location.getExits().get(direction));
					}
				}
			}
		}
//		try(BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
//		    BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))
//		) {
//			for (Location location: locations.values()) {
//				locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//				for (String direction: location.getExits().keySet()) {
//					if (!direction.equalsIgnoreCase("Q")) {
//						dirFile.write(location.getLocationID() + "," + direction + ","+location.getExits().get(direction) + "\n");
//					}
//				}
//			}
//		} catch (IOException e) {
//			System.out.println("In catch block");
//			e.printStackTrace();
//		}
	}
}
