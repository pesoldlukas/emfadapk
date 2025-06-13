// Add to app/src/main/java/com/emfad/app/models/Complex.kt
package com.emfad.app.models

data class Complex(val real: Double, val imaginary: Double) {
    operator fun times(other: Complex): Complex {
        return Complex(
            real * other.real - imaginary * other.imaginary,
            real * other.imaginary + imaginary * other.real
        )
    }
    operator fun times(scalar: Double): Complex = Complex(real * scalar, imaginary * scalar)
    operator fun div(scalar: Double): Complex = Complex(real / scalar, imaginary / scalar)
    operator fun plus(other: Complex): Complex = Complex(real + other.real, imaginary + other.imaginary)
    operator fun minus(other: Complex): Complex = Complex(real - other.real, imaginary - other.imaginary)
}

// Add to app/src/main/java/com/emfad/app/models/MeasurementOrientation.kt
package com.emfad.app.models

enum class MeasurementOrientation {
    VERTICAL,
    HORIZONTAL,
    DIAGONAL
}

// Add to app/src/main/java/com/emfad/app/data/Converters.kt
package com.emfad.app.data

import androidx.room.TypeConverter
import java.util.Date

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}