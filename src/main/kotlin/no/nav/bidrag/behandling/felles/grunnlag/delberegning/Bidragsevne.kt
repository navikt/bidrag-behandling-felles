package no.nav.bidrag.behandling.felles.grunnlag.delberegning

import com.fasterxml.jackson.annotation.JsonProperty
import no.nav.bidrag.behandling.felles.grunnlag.IGrunnlagInnhold
import java.math.BigDecimal
import java.time.LocalDate

class Bidragsevne(
  val belop: BigDecimal,
  @field:JsonProperty("25ProsentInntekt") val inntekt25Prosent: BigDecimal,
  val antallBarnDeltBosted: Int,
  val isHarFlereSaker: Boolean,
  val isHarFullBidragsevne: Boolean,
  val bidragsevneBeskrivelse: String,
  val skatt: BigDecimal,
  val aarligEvne: BigDecimal,
  grunnlagReferanseListe: List<String>,
  datoFom: LocalDate,
  datoTil: LocalDate?
) :
  Delberegning<Bidragsevne>(grunnlagReferanseListe, datoFom, datoTil), IGrunnlagInnhold {

  override fun isEqualTo(other: Bidragsevne): Boolean {
    return belop == other.belop && inntekt25Prosent == other.inntekt25Prosent && antallBarnDeltBosted == other.antallBarnDeltBosted && isHarFlereSaker == other.isHarFlereSaker && isHarFullBidragsevne == other.isHarFullBidragsevne && bidragsevneBeskrivelse == other.bidragsevneBeskrivelse && skatt == other.skatt && aarligEvne == aarligEvne
  }

}