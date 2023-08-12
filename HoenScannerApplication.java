public class HoenScannerApplication extends Application<HoenScannerConfiguration> {
    public class HoenScannerApplication extends Application<HoenScannerConfiguration> {
        @Override
        public void run(HoenScannerConfiguration configuration, Environment environment) throws Exception {
            // Load JSON files and populate a list of search results
            List<SearchResult> searchResults = loadSearchResultsFromJSONFiles();

            // Register the SearchResource and provide it with the searchResults list
            environment.jersey().register(new SearchResource(searchResults));
        }

        // ...
    }

    private List<SearchResult> loadSearchResultsFromJSONFiles() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Load and parse the first JSON file
        InputStream jsonFile1 = getClass().getResourceAsStream("/path/to/first/search/results.json");
        SearchResult[] searchResults1 = objectMapper.readValue(jsonFile1, SearchResult[].class);

        // Load and parse the second JSON file
        InputStream jsonFile2 = getClass().getResourceAsStream("/path/to/second/search/results.json");
        SearchResult[] searchResults2 = objectMapper.readValue(jsonFile2, SearchResult[].class);

        // Combine the search results from both files into a single list
        List<SearchResult> combinedSearchResults = new ArrayList<>();
        combinedSearchResults.addAll(Arrays.asList(searchResults1));
        combinedSearchResults.addAll(Arrays.asList(searchResults2));

        return combinedSearchResults;
    }

    // ... Other methods and configurations ...
}
