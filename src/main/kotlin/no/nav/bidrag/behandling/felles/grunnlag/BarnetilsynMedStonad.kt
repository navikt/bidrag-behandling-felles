package no.nav.bidrag.behandling.felles.grunnlag

import java.time.LocalDate

class BarnetilsynMedStonad(
  datoFom: LocalDate,
  datoTil: LocalDate,
  override val soknadsbarnId: Int,
  val stonadType: String,
  val tilsynType: String
) :
  Periode<BarnetilsynMedStonad>(datoFom, datoTil), IGrunnlagInnhold, ISoknadsbarn {

  override fun isEqualTo(other: BarnetilsynMedStonad): Boolean {
    return soknadsbarnId == other.soknadsbarnId && stonadType == other.stonadType && tilsynType == other.tilsynType
  }

}