#!/bin/bash

package="com.cs.ag"
app="drawing-program"
if test -n "$JAVA_HOME"; then
    JAVA="$JAVA_HOME/bin/java"
fi

echo "Please choose the steps: "
select input in "Test" "Run from Source" "Package & Run"; do
    case $input in
        Test) make
        echo "----- Running the Test : -----"
        ./mvnw test
        break;;
        "Run from Source") make
        echo "----- Running the $app from source : -----"
        ./mvnw exec:java
        break;;
        "Package & Run") make
        echo "----- Packaging the $app-1.0.jar : -----"
        ./mvnw clean package shade:shade
        echo "----- Running the $app-1.0.jar   : -----"
        cd target
        "$JAVA" -jar "$app"-1.0.jar
        break;;
    esac
done


