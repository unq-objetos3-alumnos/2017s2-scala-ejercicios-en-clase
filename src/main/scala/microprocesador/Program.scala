package microprocesador

object Instructions {

  def SWAP(estado: Estado): Estado = {
    estado.copy(
      regA = estado.regB,
      regB = estado.regA,
      pc = estado.pc + 1)
  }

  def LODV(valor: Int)(estado: Estado): Estado = {
    estado.copy(
      regA = valor,
      pc = estado.pc + 1)
  }

  def ADD(estado: Estado): Estado = {
    estado.copy(regA = estado.regA + estado.regB, pc = estado.pc + 1)
  }


}

case class Memoria()

case class Estado(
                   regA: Int,
                   regB: Int,
                   pc: Int,
                   mem: Memoria,
                 )












//case class Program(instruction: Instruction*) {
//  def execute(): Estado = {
//    instruction.foldLeft(
//      Estado(0, 0, 0, Memoria())
//    ) {
//      (estado, instruccion) => instruccion.execute(estado)
//    }
//  }
//}
