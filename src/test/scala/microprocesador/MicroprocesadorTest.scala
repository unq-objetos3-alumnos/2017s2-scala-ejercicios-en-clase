package microprocesador

import org.scalatest._

class MicroprocesadorTest extends FlatSpec {

  "A program" should "execute" in {
    import Instructions._

    val programa =
      (LODV(2)(_))
        .andThen(SWAP)
        .andThen(LODV(2))
        .andThen(ADD)

    val estadoFinal = programa(Estado(0, 0, 0, Memoria()))

    assert(estadoFinal.regA === 4)
  }
}