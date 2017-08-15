
package com.ezraerani.simplilearndemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MovieResponse {

    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("results")
    @Expose
    private List<Movie> results = new ArrayList<Movie>();

    /**
     * 
     * @return
     *     The page
     */
    public int getPage() {
        return page;
    }

    /**
     * 
     * @param page
     *     The page
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * 
     * @return
     *     The results
     */
    public List<Movie> getResults() {
        return results;
    }

    /**
     * 
     * @param results
     *     The results
     */
    public void setResults(List<Movie> results) {
        this.results = results;
    }

}
