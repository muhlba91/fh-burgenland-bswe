resource "google_cloud_run_service" "service" {
  name     = "cloudrun-service-terraform"
  location = var.region

  template {
    spec {
      containers {
        image = var.image_name
        resources {
          limits = {
            memory = var.memory
            cpu    = var.cpu
          }
        }
        ports {
          container_port = var.container_port
        }
      }
    }
  }
}

data "google_iam_policy" "noauth" {
  binding {
    role = "roles/run.invoker"
    members = [
      "allUsers",
    ]
  }
}

resource "google_cloud_run_service_iam_policy" "service-noauth" {
  location = google_cloud_run_service.service.location
  project  = google_cloud_run_service.service.project
  service  = google_cloud_run_service.service.name

  policy_data = data.google_iam_policy.noauth.policy_data
}
