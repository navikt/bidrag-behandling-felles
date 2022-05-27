package no.nav.bidrag.behandling.felles.grunnlag

import no.nav.bidrag.behandling.felles.enums.BostatusKode
import no.nav.bidrag.behandling.felles.enums.Rolle
import java.time.LocalDate

class Bostatus(
  override val rolle: Rolle,
  datoFom: LocalDate,
  datoTil: LocalDate,
  val bostatusKode: BostatusKode,
  override val soknadsbarnId: Int
) : Periode<Bostatus>(datoFom, datoTil), IGrunnlagInnhold, ISoknadsbarn, IRolle {

  override fun isEqualTo(other: Bostatus): Boolean {
    return rolle == other.rolle && bostatusKode == other.bostatusKode && soknadsbarnId == other.soknadsbarnId
  }
}