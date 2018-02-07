package com.rahul.phmc.spe.sdp.resource;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.rahul.phmc.spe.sdp.services.SPE_SDP_UploadSettlementService;
import com.rahul.phmc.util.ErrorMessage;
import com.rahul.phmc.util.PHMC_DB_ERROR;

/**
 * @author rahul makvana this class is Resource of Get input from user for
 *         Upload Settlement data
 */
@Path("settlement")
public class SPE_SDP_UploadSettlementResource {

	// this is creation of logger so we can check what log created.
	static final Logger log = Logger.getLogger(SPE_SDP_UploadSettlementResource.class);

	ErrorMessage spe_sdp_error = new ErrorMessage();
	Response response = null;
	SPE_SDP_UploadSettlementService uploadService = new SPE_SDP_UploadSettlementService();

	@POST
	@Path("/upload")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response SPE_SDP_uploadSettlement(@FormDataParam("SPE_file") InputStream uploadedInputStream,
			@FormDataParam("SPE_file") FormDataContentDisposition fileDetail,
			@QueryParam("SPE_Provider") String SPE_ProviderName, @QueryParam("SPE_mode") Integer SPE_PaymentMode) {

		//try {
			if (!SPE_ProviderName.isEmpty() && SPE_PaymentMode != null) {
				if (uploadedInputStream != null && !fileDetail.getFileName().equals("")) {
					log.info(uploadedInputStream);
					log.info(fileDetail.getFileName());
					log.info(SPE_ProviderName);
					log.info(SPE_PaymentMode);
					response = uploadService.spe_sdp_uploadSettlement(uploadedInputStream, fileDetail, SPE_ProviderName,
							SPE_PaymentMode);

				} else {
					log.info("file not uploaded properly");
					spe_sdp_error.setErrorCode(PHMC_DB_ERROR.PHMC_INVALID_INPUT);
					spe_sdp_error.setErrorMessage("Please give Valid Input");
					response = Response.status(spe_sdp_error.getErrorCode()).entity(spe_sdp_error).build();
				}
			} else {
				log.info("bank name or mode is empty");
				spe_sdp_error.setErrorCode(PHMC_DB_ERROR.PHMC_INVALID_INPUT);
				spe_sdp_error.setErrorMessage("Please give valid provider");
				response = Response.status(spe_sdp_error.getErrorCode()).entity(spe_sdp_error).build();
			}
		/*} catch (NullPointerException e) {
			log.error(e.getMessage());
			spe_sdp_error.setErrorCode(PHMC_DB_ERROR.PHMC_INVALID_INPUT);
			spe_sdp_error.setErrorMessage("Server Error");
			response = Response.status(spe_sdp_error.getErrorCode()).entity(spe_sdp_error).build();
		} catch (Exception e) {
			log.error(e.getMessage());
			spe_sdp_error.setErrorCode(PHMC_DB_ERROR.PHMC_DB_NOT_AVAILABLE);
			spe_sdp_error.setErrorMessage("Server Time Out Try again");
			response = Response.status(spe_sdp_error.getErrorCode()).entity(spe_sdp_error).build();
		}*/

		return response;
	}

}
