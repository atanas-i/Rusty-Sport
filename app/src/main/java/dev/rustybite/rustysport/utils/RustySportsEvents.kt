package dev.rustybite.rustysport.utils

sealed class RustySportsEvents {
    data class Navigate(val route: String) : RustySportsEvents()
    data object PopBackStack : RustySportsEvents()
    data class ShowSnackBar(val message: String) : RustySportsEvents()
    data class ShowToast(val message: String) : RustySportsEvents()
}