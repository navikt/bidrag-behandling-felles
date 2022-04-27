package no.nav.bidrag.behandling.felles.grunnlag

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import java.time.LocalDate
import java.util.Objects

abstract class Periode<T>(
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @JsonSerialize(using = LocalDateSerializer::class)
  @JsonDeserialize(using = LocalDateDeserializer::class)
  var datoFom: LocalDate,
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @JsonSerialize(using = LocalDateSerializer::class)
  @JsonDeserialize(using = LocalDateDeserializer::class)
  var datoTil: LocalDate
) {

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other == null || javaClass != other.javaClass) return false
    val periode = other as Periode<*>
    return datoFom == periode.datoFom && datoTil == periode.datoTil
  }

  override fun hashCode(): Int {
    return Objects.hash(datoFom, datoTil)
  }

  abstract fun isEqualTo(other: T): Boolean
}