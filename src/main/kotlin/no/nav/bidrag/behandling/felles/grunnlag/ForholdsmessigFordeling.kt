package no.nav.bidrag.behandling.felles.grunnlag

import java.math.BigDecimal
import java.time.LocalDate

class ForholdsmessigFordeling(
  val sakId: String,
  val fnrBarn: String,
  datoFom: LocalDate,
  datoTil: LocalDate?,
  val datoBeregnet: LocalDate,
  val samvaersfradragBelop: BigDecimal,
  val beregnetBidragBelop: BigDecimal,
  val endeligBidragBelop: BigDecimal,
  val resultatkode: String,
  val status: String
) : Periode<ForholdsmessigFordeling>(datoFom, datoTil), IGrunnlagInnhold {

  override fun isEqualTo(other: ForholdsmessigFordeling): Boolean {
    return sakId == other.sakId && fnrBarn == other.fnrBarn && datoBeregnet == other.datoBeregnet && samvaersfradragBelop == other.samvaersfradragBelop
        && beregnetBidragBelop == other.beregnetBidragBelop && endeligBidragBelop == other.endeligBidragBelop && resultatkode == other.resultatkode
        && status == other.status
  }
}