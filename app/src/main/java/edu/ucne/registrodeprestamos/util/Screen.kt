package edu.ucne.registrodeprestamos.util

sealed class Screen(val route: String) {
    object OcupacionScreen: Screen("Ocupacion")
    object OcupacionListScreen: Screen("OcupacionList")
    object PersonaScreen: Screen("Persona")
    object PersonaListScreen: Screen("PersonaList")
}