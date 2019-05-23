package com.rroggia.day3;

import java.util.ArrayList;
import java.util.List;

import com.rroggia.utils.IOUtils;

public class Day3 {

	public static void main(String[] args) {
		List<String> claimsAsString = IOUtils.readStringsFromInputFile("/day3/input");
		List<Claim> claims = transformStringToClaim(claimsAsString);

		String[][] fabric = new String[1000][1000];

		int squaresClaimedByTwoOrMore = 0;

		for (Claim claim : claims) {
			for (int i = 0; i < claim.getHeight(); i++) {
				for (int j = 0; j < claim.getWidth(); j++) {
					if (fabric[claim.getDistanceTopEdge() + i][claim.getDistanceLeftEdge() + j] == null) {
						fabric[claim.getDistanceTopEdge() + i][claim.getDistanceLeftEdge() + j] = "X";
					} else if ("X".equals(fabric[claim.getDistanceTopEdge() + i][claim.getDistanceLeftEdge() + j])) {
						fabric[claim.getDistanceTopEdge() + i][claim.getDistanceLeftEdge() + j] = "XA";
						squaresClaimedByTwoOrMore++;
					}
				}
			}
		}

		for (Claim claim : claims) {
			boolean differentThanX = false;
			for (int i = 0; i < claim.getHeight(); i++) {
				for (int j = 0; j < claim.getWidth(); j++) {
					if (!"X".equals(fabric[claim.getDistanceTopEdge() + i][claim.getDistanceLeftEdge() + j])) {
						differentThanX = true;
						break;
					}
				}
				if (differentThanX)
					break;
			}
			if (!differentThanX)
				System.out.println(claim.getId());
		}

		System.out.println(squaresClaimedByTwoOrMore);
	}

	private static List<Claim> transformStringToClaim(List<String> claimsAsString) {
		List<Claim> claims = new ArrayList<Claim>();

		for (String claimAsString : claimsAsString) {

			Claim claim = new Claim();

			int indexOfID = claimAsString.indexOf("@");
			String id = claimAsString.substring(1, indexOfID).trim();
			claim.setId(Integer.parseInt(id));

			int indexOfBeginDistancesFromEdge = claimAsString.indexOf(":");

			String distancesFromEdge = claimAsString.substring(indexOfID + 1, indexOfBeginDistancesFromEdge);
			String[] split = distancesFromEdge.split(",");
			claim.setDistanceLeftEdge(Integer.parseInt(split[0].trim()));
			claim.setDistanceTopEdge(Integer.parseInt(split[1].trim()));

			String rectangle = claimAsString.substring(indexOfBeginDistancesFromEdge + 1, claimAsString.length())
					.trim();
			String[] split2 = rectangle.split("x");
			claim.setWidth(Integer.parseInt(split2[0]));
			claim.setHeight(Integer.parseInt(split2[1]));

			claims.add(claim);

		}

		return claims;
	}
}
