package com.truecar.mleap.learning.estimator

/**
  * Created by hwilkins on 11/18/15.
  */
case class VectorAssemblerEstimator(name: String = Estimator.createName("vectorAssembler"),
                                    inputCols: Seq[String],
                                    outputCol: String) extends Estimator
