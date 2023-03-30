package no.nav.bidrag.behandling.felles.grunnlag.delberegning

import no.nav.bidrag.behandling.felles.grunnlag.IGrunnlagInnhold
import no.nav.bidrag.behandling.felles.grunnlag.ISoknadsbarn
import java.math.BigDecimal
import java.time.LocalDate

class Underholdskostnad(
    override val soknadsbarnId: Int,
    val belop: BigDecimal,
    val beregnetBelop: BigDecimal,
    val skolealderKode: String,
    val manueltJustertSmaabarnstillegg: Boolean,
    val smaabarnstillegg: BigDecimal,
    grunnlagReferanseListe: List<String>,
    datoFom: LocalDate,
    datoTil: LocalDate?
) :
    Delberegning<Underholdskostnad>(grunnlagReferanseListe, datoFom, datoTil), IGrunnlagInnhold, ISoknadsbarn {

    override fun isEqualTo(other: Underholdskostnad): Boolean {
        return soknadsbarnId == other.soknadsbarnId && belop == other.belop
    }
}
