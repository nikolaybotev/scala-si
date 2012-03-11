object SI_5559 extends App {

  object TypedProps {
    def apply[T <: AnyRef](interface: Class[_ >: T], implementation: Class[T]): TypedProps[T] =
      new TypedProps[T](interface, implementation)
  }
  class TypedProps[T <: AnyRef](val interface: Class[_ >: T], val implementation: Class[T])

  trait Test {
    def typedActorOf[R <: AnyRef, T <: R](props: TypedProps[T]): R

    def namedActorFor[R <: AnyRef, T <: R](interface: Class[R], impl: Class[T]): R = 
      typedActorOf(TypedProps[T](interface, impl))
    //typedActorOf(TypedProps(interface, impl)) - Compilation Error
    
  }

}
