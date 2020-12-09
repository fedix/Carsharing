package com.fedosique.carsharing.storage

import com.fedosique.carsharing.User

import java.util.UUID

trait UserStorage[F[_]] {
  def put(user: User): F[User]

  def update(id: UUID, user: User): F[User]

  def get(id: UUID): F[Option[User]]

  def contains(id: UUID): F[Boolean]
}