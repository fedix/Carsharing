package com.fedosique.carsharing

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import com.fedosique.carsharing.logic.ClientServiceModule
import com.fedosique.carsharing.storage.InMemoryCarStorage


object HttpApp extends App {

  implicit val actorSystem: ActorSystem = ActorSystem()
  implicit val ec = actorSystem.dispatcher

  val storage = new InMemoryCarStorage
  private val clientServiceModule = new ClientServiceModule(storage)

  Http()
    .newServerAt("localhost", 8080)
    .bind(clientServiceModule.routes)
    .foreach(s => println(s"server started at $s"))
}
