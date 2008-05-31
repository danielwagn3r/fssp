/*
 *  JFSSP - A Flow Shop Scheduler in Java
 *  
 *  Copyright (C) 2007  Daniel Wagner <dwkwaxi@gmail.com>
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *  
 *  $Id$
 */

package org.kwaxi.jfssp;

import org.apache.commons.cli.*;

/**
 * @author Daniel Wagner <dwkwaxi@gmail.com>
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create the command line parser
		CommandLineParser parser = new PosixParser();

		// create the Options
		Options options = new Options();

		options.addOption(OptionBuilder.hasArg().withArgName("gn").withLongOpt(
				"generations").withDescription(
				"Number of generations [default: 50]").withType(new Integer(0))
				.create("g"));

		options.addOption(OptionBuilder.hasArg().withArgName("mp").withLongOpt(
				"mutation").withDescription(
				"Mutation propability [default: 0.5]").withType(new Double(0))
				.create("m"));

		options.addOption(OptionBuilder.hasArg().withArgName("ps").withLongOpt(
				"populationsize").withDescription(
				"Size of population [default: 20]").withType(new Integer(0))
				.create("p"));

		options.addOption(OptionBuilder.hasArg().withArgName("rp").withLongOpt(
				"recombination").withDescription(
				"Recombination propability [default: 0.8]").withType(
				new Double(0)).create("r"));

		options.addOption(OptionBuilder.hasArg().withArgName("sp").withLongOpt(
				"selectionpressure").withDescription(
				"Selection pressure [default: 4]").withType(new Integer(0))
				.create("s"));

		options.addOption(OptionBuilder.withLongOpt("help").withDescription(
				"print this message").create("h"));

		options.addOption(OptionBuilder.hasArg().withArgName("filename")
				.isRequired().withLongOpt("file").withDescription(
						"Problem file [default: \"\"]").withType(new String())
				.create("f"));

		options.addOptionGroup(new OptionGroup().addOption(
				OptionBuilder.withLongOpt("verbose").withDescription(
						"be extra verbose").create("v")).addOption(
				OptionBuilder.withLongOpt("quiet").withDescription(
						"be extra quiet").create("q")));

		options.addOption(OptionBuilder.withLongOpt("version").withDescription(
				"print the version information and exit").create("V"));

		try {
			// parse the command line arguments
			CommandLine line = parser.parse(options, args);

			// validate that block-size has been set
			if (line.hasOption("h")) {
				// automatically generate the help statement
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp("jfssp", options);
			}
			
		}
		catch (MissingOptionException exp ){
			System.out.println("An option was missing");
			
			// automatically generate the help statement
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("jfssp", options);
		}
		catch (MissingArgumentException exp ){
			System.out.println("An argument was missing");

			// automatically generate the help statement
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("jfssp", options);
		}
		catch (AlreadySelectedException exp ){
			// automatically generate the help statement
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("jfssp", options);
		}
		catch (ParseException exp) {
			System.out.println("Unexpected exception:" + exp.getMessage());

			// automatically generate the help statement
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("jfssp", options);
		}
	}
}
