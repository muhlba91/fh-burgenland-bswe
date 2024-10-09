output "url" {
  description = "the URL of the deployed service"
  value       = google_cloud_run_service.service.status[0].url
}
