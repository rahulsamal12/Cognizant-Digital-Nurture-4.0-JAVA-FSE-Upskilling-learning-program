package com.greetings;

import com.utils.Utils;

public class Main {
    public static void main(String[] args) {
        Utils.greet("OpenAI");
    }
}
/*
javac -d out --module-source-path . $(find . -name "*.java")
java --module-path out -m com.greetings/com.greetings.Main
 */