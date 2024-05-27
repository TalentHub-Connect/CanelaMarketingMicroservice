import os
import xml.etree.ElementTree as ET
import matplotlib.pyplot as plt

def parse_surefire_reports(directory):
    results = {
        "tests": 0,
        "failures": 0,
        "errors": 0,
        "skipped": 0
    }
    
    for file_name in os.listdir(directory):
        if file_name.endswith(".xml"):
            file_path = os.path.join(directory, file_name)
            tree = ET.parse(file_path)
            root = tree.getroot()
            
            results["tests"] += int(root.attrib.get("tests", 0))
            results["failures"] += int(root.attrib.get("failures", 0))
            results["errors"] += int(root.attrib.get("errors", 0))
            results["skipped"] += int(root.attrib.get("skipped", 0))
    
    return results

def plot_results(results):
    labels = ["Tests", "Failures", "Errors", "Skipped"]
    values = [results["tests"], results["failures"], results["errors"], results["skipped"]]
    colors = ['#4CAF50', '#F44336', '#FF9800', '#9E9E9E']
    
    plt.figure(figsize=(10, 6))
    bars = plt.bar(labels, values, color=colors)
    
    plt.title('Unit Test Results Marketing')
    plt.ylabel('Number of Tests')
    
    for bar in bars:
        yval = bar.get_height()
        plt.text(bar.get_x() + bar.get_width()/2, yval, int(yval), va='bottom')
    
    plt.show()

# Path to the Surefire reports directory
surefire_reports_dir = "target/surefire-reports"

# Parse the Surefire reports and plot the results
results = parse_surefire_reports(surefire_reports_dir)
plot_results(results)
