package eu.darken.sdmse.common.forensics.csi

import eu.darken.sdmse.common.forensics.AreaInfo
import eu.darken.sdmse.common.forensics.CSIProcessor
import eu.darken.sdmse.common.forensics.Owner
import eu.darken.sdmse.common.pkgs.PkgRepo

interface LocalCSIProcessor : CSIProcessor {

    suspend fun PkgRepo.isInstalled(owner: Owner): Boolean = isInstalled(owner.pkgId)

    override suspend fun findOwners(areaInfo: AreaInfo): CSIProcessor.Result {
        require(hasJurisdiction(areaInfo.type)) { "Wrong jurisdiction: ${areaInfo.type}" }
        return CSIProcessor.Result()
    }
}