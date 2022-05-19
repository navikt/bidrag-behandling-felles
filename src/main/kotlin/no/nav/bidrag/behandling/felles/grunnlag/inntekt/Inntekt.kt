package no.nav.bidrag.behandling.felles.grunnlag.inntekt

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import no.nav.bidrag.behandling.felles.enums.InntektType
import no.nav.bidrag.behandling.felles.enums.Rolle
import no.nav.bidrag.behandling.felles.grunnlag.IGrunnlagInnhold
import no.nav.bidrag.behandling.felles.grunnlag.Periode
import no.nav.bidrag.behandling.felles.grunnlag.deserializer.InntektDeserializer
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*


open class Inntekt(
  val rolle: Rolle,
  val inntektType: InntektType,
  val belop: BigDecimal,
  val valgt: Boolean,
  datoFom: LocalDate,
  datoTil: LocalDate,
  @JsonDeserialize(contentUsing = InntektDeserializer::class)
  var inntekter: List<IInntektGrunnlag>
) :
  Periode<Inntekt>(datoFom, datoTil), IGrunnlagInnhold {

  override fun equals(o: Any?): Boolean {
    if (this === o) return true
    if (o == null || javaClass != o.javaClass) return false
    val inntekt = o as Inntekt
    return valgt == inntekt.valgt && rolle === inntekt.rolle && inntektType == inntekt.inntektType && belop == inntekt.belop && datoFom == inntekt.datoFom && datoTil == inntekt.datoTil
  }

  override fun hashCode(): Int {
    return Objects.hash(rolle, inntektType, belop, valgt)
  }

  override fun isEqualTo(other: Inntekt): Boolean {
    return rolle == other.rolle && inntektType == other.inntektType && belop == other.belop && valgt == other.valgt
  }

}