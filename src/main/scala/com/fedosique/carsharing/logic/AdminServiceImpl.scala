package com.fedosique.carsharing.logic

import java.util.UUID
import com.fedosique.carsharing.{Car, User}
import com.fedosique.carsharing.storage.{CarStorage, UserStorage}
import monix.eval.Task

class AdminServiceImpl(carStorage: CarStorage[Task], userStorage: UserStorage[Task]) extends AdminService[Task] {

  override def getCar(id: UUID): Task[Option[Car]] = carStorage.get(id)

  override def addCar(car: Car): Task[UUID] = {
    val id = UUID.randomUUID()
    carStorage.put(id, car).flatMap(_ => Task.now(id))
  }

  override def cars: Task[Seq[Car]] = carStorage.listAll()

  override def addUser(name: String, email: String): Task[User] = {
    val user = User(UUID.randomUUID(), name, email, isRenting = false)
    userStorage.put(user).map(_ => user)
  }

  override def getUser(id: UUID): Task[Option[User]] = userStorage.get(id)

}
