package no.nav.bidrag.behandling.felles.grunnlag

import no.nav.bidrag.behandling.felles.enums.Rolle
import java.math.BigDecimal
import java.time.LocalDate

class Barnetillegg(
  override val rolle: Rolle,
  override val soknadsbarnId: Int,
  val bruttoBelop: BigDecimal,
  val skattProsent: BigDecimal,
  val kilde: String,
  datoFom: LocalDate,
  datoTil: LocalDate?
) :
  Periode<Barnetillegg>(datoFom, datoTil), IGrunnlagInnhold, ISoknadsbarn, IRolle {

  override fun isEqualTo(other: Barnetillegg): Boolean {
    return rolle == other.rolle && soknadsbarnId == other.soknadsbarnId && bruttoBelop == other.bruttoBelop && skattProsent == other.skattProsent && kilde == other.kilde
  }

}