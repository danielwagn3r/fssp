  FSSP - A Flow Shop Scheduler
  Copyright (C) 2002  Daniel Wagner <daniel@kwaxi.org>

  This program is free software; you can redistribute it and/or modify
  it under the terms of the GNU General Public License as published by
  the Free Software Foundation; either version 2 of the License, or
  (at your option) any later version.
  
  This program is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU General Public License for more details.
  
  You should have received a copy of the GNU General Public License
  along with this program; if not, write to the Free Software
  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
  
  $Id$


Requirements:

A gcc compatible C compiler.


Installation:

cd [source-directory]
make


Usage:

./fssp [Options] file

Options:
  -g, --generations <ushort>          Count of generations [Default: 50]
  -m, --mutation <double>             Mutation-Feasibility [Default: 0.5]
  -p, --populationsize <ushort>       Size of population [Default: 20]
  -r, --recombination <double>        Recombination-Feasibility [Default: 0.8]
  -s, --selectionpressure <ushort>    Selection-Pressure [Default: 4]
  -h, --help                          Display this help screen

Arguments:
  file                                File to load
