package no.nav.bidrag.behandling.felles.grunnlag

class SoknadsbarnInfo(override val soknadsbarnId: Int, val fodselsdato: String, val fnr: String) : IGrunnlagInnhold, ISoknadsbarn {}