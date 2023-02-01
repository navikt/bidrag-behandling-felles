package no.nav.bidrag.behandling.felles.grunnlag

import java.math.BigDecimal
import java.time.LocalDate

class ForholdsmessigFordeling(
  val justerFomDato: LocalDate,
  datoFom: LocalDate,
  datoTil: LocalDate?,
  val soknadTypeKode: String,
  val datoSoknad: LocalDate,
  val sakId: String,
  val fiktivSakId: String,
  val fnrBarn: String,
  val datoBeregnet: LocalDate?,
  val samvaersfradragBelop: BigDecimal,
  val beregnetBidragBelop: BigDecimal,
  val endeligBidragBelop: BigDecimal,
  val resultatkode: String,
  val status: String
) : Periode<ForholdsmessigFordeling>(datoFom, datoTil), IGrunnlagInnhold {

  override fun isEqualTo(other: ForholdsmessigFordeling): Boolean {
    return soknadTypeKode == other.soknadTypeKode && datoSoknad == other.datoSoknad && sakId == other.sakId && fnrBarn == other.fnrBarn
        && datoBeregnet == other.datoBeregnet
  }
}