package no.nav.bidrag.behandling.felles.grunnlag

import no.nav.bidrag.domain.enums.BostatusKode
import no.nav.bidrag.domain.enums.Rolle
import java.time.LocalDate

class BostatusBP(val bostatusKode: BostatusKode, datoFom: LocalDate, datoTil: LocalDate?) :
    Periode<BostatusBP>(datoFom, datoTil),
    IGrunnlagInnhold,
    IRolle {
    override val rolle = Rolle.BIDRAGSPLIKTIG

    override fun isEqualTo(other: BostatusBP): Boolean {
        return bostatusKode == other.bostatusKode && rolle == other.rolle
    }
}
