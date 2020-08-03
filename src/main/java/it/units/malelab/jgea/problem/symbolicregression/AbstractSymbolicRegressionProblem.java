/*
 * Copyright (C) 2020 Eric Medvet <eric.medvet@gmail.com> (as eric)
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *  See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package it.units.malelab.jgea.problem.symbolicregression;

import it.units.malelab.jgea.core.Problem;
import it.units.malelab.jgea.core.ProblemWithValidation;
import it.units.malelab.jgea.representation.tree.Node;
import it.units.malelab.jgea.core.fitness.CaseBasedFitness;
import it.units.malelab.jgea.representation.grammar.Grammar;
import it.units.malelab.jgea.representation.grammar.GrammarBasedProblem;
import it.units.malelab.jgea.problem.symbolicregression.element.Element;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author eric
 */
public abstract class AbstractSymbolicRegressionProblem implements ProblemWithValidation<RealFunction, Double> {

  private final SymbolicRegressionFitness trainingFitness;
  private final SymbolicRegressionFitness validationFitness;
  private RealFunction targetFunction;

  public AbstractSymbolicRegressionProblem(RealFunction targetFunction, List<double[]> trainingPoints, List<double[]> validationPoints) {
    this.targetFunction = targetFunction;
    trainingFitness = new SymbolicRegressionFitness(targetFunction, trainingPoints);
    validationFitness = new SymbolicRegressionFitness(targetFunction, validationPoints);
  }

  public AbstractSymbolicRegressionProblem(RealFunction targetFunction, List<double[]> trainingPoints) {
    this.targetFunction = targetFunction;
    trainingFitness = new SymbolicRegressionFitness(targetFunction, trainingPoints);
    validationFitness = new SymbolicRegressionFitness(targetFunction, trainingPoints);
  }

  @Override
  public Function<RealFunction, Double> getValidationFunction() {
    return validationFitness;
  }

  @Override
  public Function<RealFunction, Double> getFitnessFunction() {
    return trainingFitness;
  }

  public RealFunction getTargetFunction() {
    return targetFunction;
  }
}
