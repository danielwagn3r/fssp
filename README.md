fssp
====

A simple Flow-Shop scheduler in Java

Requirements
------------
- Java SDK 1.7
- Apache Maven 3.1.x


Installation
------------

~~~ sh
cd [source-directory]
mvn package
~~~

Usage
-----

~~~
./fssp [Options] file
~~~

### Options
~~~
  -g, --generations <ushort>          Count of generations [Default: 50]
  -m, --mutation <double>             Mutation-Feasibility [Default: 0.5]
  -p, --populationsize <ushort>       Size of population [Default: 20]
  -r, --recombination <double>        Recombination-Feasibility [Default: 0.8]
  -s, --selectionpressure <ushort>    Selection-Pressure [Default: 4]
  -h, --help                          Display this help screen
~~~

### Arguments
~~~
  file                                File to load
~~~
