package com.exeevo.flows;

import com.exeevo.pageFactory.TabletsPage;

public class TabletsFlow {

	private TabletsPage objTabletsPage;

	public TabletsFlow() {
		objTabletsPage = new TabletsPage();
	}

	/**
	 * selectFilter - A reusable method to select a filter as per the requirement.
	 * @param filters - The available filters to choose from.
	 * @param options - The options to apply for the selected filter.
	 */
	public void selectFilter(String filters, String... options) {
		objTabletsPage.clickOnClearAll();
		for (String option : options) {
			if (option.equalsIgnoreCase("All")) {
				String[] allOptions = { "Apple", "Samsung", "T-Mobile", "TCL" };
				for (String option1 : allOptions) {
					objTabletsPage.applyFilter(filters, option1);
				}

			} else {
				objTabletsPage.applyFilter(filters, option);
			}
		}
	}

}
