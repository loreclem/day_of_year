#!/bin/bash
javac DOY.java
cp *class build
rm build/doy.jar
cd build
jar cfe doy.jar DOY DOY.class DayOfYear.class
cd ..
cp build/doy.jar .
echo "Done!"
time
