/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.units.malelab.jgea.problem.classification;

import it.units.malelab.jgea.core.fitness.Classification;
import it.units.malelab.jgea.core.util.Pair;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author eric
 */
public class FileRegexClassification extends GrammarBasedRegexClassification {

  private static List<Pair<String, Label>> buildData(String positiveFileName, String negativeFileName) throws IOException {
    List<Pair<String, Label>> data = new ArrayList<>();
    data.addAll(Files.lines(Paths.get(positiveFileName)).map(s -> Pair.build(s, Label.FOUND)).collect(Collectors.toList()));
    data.addAll(Files.lines(Paths.get(negativeFileName)).map(s -> Pair.build(s, Label.NOT_FOUND)).collect(Collectors.toList()));
    return data;
  }

  public FileRegexClassification(String positiveFileName, String negativeFileName, int folds, int i, Classification.ErrorMetric learningErrorMetric, Classification.ErrorMetric validationErrorMetric) throws IOException {
    super(null,
            new LinkedHashSet<>(Arrays.asList(Option.ANY, Option.OR, Option.CHAR_CLASS, Option.ENHANCED_CONCATENATION)),
            buildData(positiveFileName, negativeFileName),
            folds, i,
            learningErrorMetric, validationErrorMetric);
  }

}