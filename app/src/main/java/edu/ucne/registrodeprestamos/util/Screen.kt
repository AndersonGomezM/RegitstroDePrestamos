package edu.ucne.registrodeprestamos.util

sealed class Screen(val route: String) {
    object HomeScreen: Screen("Home")
    object OcupacionScreen: Screen("Ocupacion")
    object OcupacionListScreen: Screen("OcupacionList")
    object PersonaScreen: Screen("Persona")
    object PersonaListScreen: Screen("PersonaList")
    object PrestamoScreen: Screen("Prestamo")
    object PrestamoListScreen: Screen("PrestamoList")
}