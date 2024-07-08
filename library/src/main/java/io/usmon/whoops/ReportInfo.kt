package io.usmon.whoops

/**
 * The ReportInfo class represents configuration options for crash reporting.
 *
 * @property androidVersion Whether to include the Android version in crash reports.
 * @property deviceInfo Whether to include device information in crash reports.
 * @property supportedABIs Whether to include supported ABIs in crash reports.
 * @property reportUrl The URL to which crash reports should be sent.
 */
public class ReportInfo(
    var androidVersion: Boolean = true,
    var deviceInfo: Boolean = true,
    var supportedABIs: Boolean = true,
    var reportUrl: String? = null,
)
