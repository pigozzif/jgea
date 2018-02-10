/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.units.malelab.jgea.core.operator;

import it.units.malelab.jgea.core.mapper.Mapper;
import java.util.List;

/**
 *
 * @author eric
 */
public interface GeneticOperator<G> extends Mapper<List<G>, List<G>> {
  
  public int arity();
  
}