package com.epam.composite.reader;

import com.epam.composite.exception.CompositeException;
import java.util.List;


public interface CustomReader {
    List<String> readLines(String filePath) throws CompositeException;
}
