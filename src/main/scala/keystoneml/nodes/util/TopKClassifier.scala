package keystoneml.nodes.util

import breeze.linalg.{DenseVector, argtopk}
import keystoneml.workflow.Transformer

/**
 * Transformer that returns the indices of the largest k values of the vector, in order
 */
class TopKClassifier(k: Int) extends Transformer[DenseVector[Double], Array[Int]] {
  override def apply(in: DenseVector[Double]): Array[Int] = {
    in.toArray.zipWithIndex.sortBy(-_._1).take(k).map(_._2)
  }
}

/**
 * Object to allow creating top k classifier w/o new
 */
object TopKClassifier {
  def apply(k: Int) = new TopKClassifier(k)
}
