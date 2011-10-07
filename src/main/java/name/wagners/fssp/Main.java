/*
 * FSSP - A Flow Shop Scheduler in Java
 *
 * Copyright (C) 2008  Daniel Wagner <daniel@wagners.name>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * $Id$
 */

package name.wagners.fssp;

import org.apache.commons.cli.AlreadySelectedException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.MissingOptionException;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Daniel Wagner <daniel@wagners.name>
 *
 */
public class Main {

    /**
     * My Log class.
     */
    private static Log log = LogFactory.getLog(Main.class);

    /**
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        // create the command line parser
        CommandLineParser parser = new PosixParser();

        // create the Options
        Options options = new Options();

        options.addOption(OptionBuilder.hasArg().withArgName("gn").withLongOpt(
                "generations").withDescription(
                "Number of generations [default: 50]").withType(
                Integer.valueOf(0)).create("g"));

        options.addOption(OptionBuilder.hasArg().withArgName("mp").withLongOpt(
                "mutation").withDescription(
                "Mutation propability [default: 0.5]").withType(
                Double.valueOf(0)).create("m"));

        options.addOption(OptionBuilder.hasArg().withArgName("ps").withLongOpt(
                "populationsize").withDescription(
                "Size of population [default: 20]")
                .withType(Integer.valueOf(0)).create("p"));

        options.addOption(OptionBuilder.hasArg().withArgName("rp").withLongOpt(
                "recombination").withDescription(
                "Recombination propability [default: 0.8]").withType(
                Double.valueOf(0)).create("r"));

        options.addOption(OptionBuilder.hasArg().withArgName("sp").withLongOpt(
                "selectionpressure").withDescription(
                "Selection pressure [default: 4]").withType(Integer.valueOf(0))
                .create("s"));

        options.addOption(OptionBuilder.withLongOpt("help").withDescription(
                "print this message").create("h"));

        options.addOption(OptionBuilder.hasArg().withArgName("filename")
                .isRequired().withLongOpt("file").withDescription(
                        "Problem file [default: \"\"]").withType(
                        String.valueOf("")).create("f"));

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
                formatter.printHelp("fssp", options);
            }

        } catch (MissingOptionException exp) {
            log.info("An option was missing:" + exp.getMessage(), exp);

            // automatically generate the help statement
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("fssp", options);
        } catch (MissingArgumentException exp) {
            log.info("An argument was missing:" + exp.getMessage(), exp);

            // automatically generate the help statement
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("fssp", options);
        } catch (AlreadySelectedException exp) {
            // automatically generate the help statement
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("fssp", options);
        } catch (ParseException exp) {
            log.info("Unexpected exception:" + exp.getMessage(), exp);

            // automatically generate the help statement
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("fssp", options);

            System.exit(1);
        }

        // Ausgabe der eingestellten Optionen

        log.info("Configuration");
        // log.info(" Datafile: " + fname);
    }

}
