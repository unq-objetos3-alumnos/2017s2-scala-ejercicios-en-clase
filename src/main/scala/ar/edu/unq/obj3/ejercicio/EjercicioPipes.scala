package ar.edu.unq.obj3.ejercicio

trait ConNombre {
  def nombre:String
}

case class Humano(nombre:String, altura:Int)
  extends ConNombre

case class SuperHeroe(identidad:ConNombre, disfraz: Disfraz)

object SuperHeroe {
  def crearDisfraz()(normal:Humano):Disfraz =
    Disfraz(normal.altura)

  def vestir(conNombre: ConNombre)(disfraz: Disfraz) =
    new SuperHeroe(conNombre,disfraz)
}

object Pipe {
  implicit class ImplicitPipe[T](val o:T) {
    def |>[R](transform:(T)=> R ) : R = transform(o)
  }
}

case class Disfraz(largo:Int)

object Main extends App {

  import SuperHeroe._
  import Pipe.ImplicitPipe
  private val humano = Humano("Pepe", 160)

  val posta = new ImplicitPipe(humano).|>(crearDisfraz())

  val superHeroe = humano |> crearDisfraz() |> vestir(humano)

  println(superHeroe)
}


