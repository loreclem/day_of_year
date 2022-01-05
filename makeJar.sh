#!/bin/bash
javac DOY.java
cp *class build
cd build
rm doy.jar
jar cfe doy.jar DOY DOY.class DayOfYear.class
cp doy.jar ..
cd ..
