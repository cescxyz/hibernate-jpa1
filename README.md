# hibernate-jpa1
Ejercicio usando hibernate y JPA (no web) configurando H2 y/o MySql

Se creó usando Maven y STS


Para el commit de integracion con mongodb
Ejecutar las sigueintes instrucciones para integrar mongo en su db


1
> use mydb
2
 
3
> db.mycollection.insertMany( [
4
    { "id" : "101", "name" : "Daniel Atlas" }, 
5
    { "id" : "102", "name" : "Charlotte Neil" },
6
    { "id" : "97", "name" : "tom jackmen" }
7
] )
8
 
9
> db.mycollection.find()


Esto habilita la base de datos a usar